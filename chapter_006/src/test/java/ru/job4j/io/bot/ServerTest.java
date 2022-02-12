package ru.job4j.io.bot;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {

    private static final String LN = System.lineSeparator();

    /**
     * Заполняет входные данные и имитирует работу серверной части бота.
     * Сравнивает выходные данные с ожидаемым результатом.
     *
     * @param input    данные
     * @param expected результат
     */
    private void testServer(String input, String expected) {
        Socket socket = mock(Socket.class);
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes())
        ) {
            when(socket.getInputStream()).thenReturn(in);
            when(socket.getOutputStream()).thenReturn(out);
            Server server = new Server(socket);
            server.start();
            assertThat(out.toString(), is(expected));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Проверить операцию выхода.
     */
    @Test
    public void whenAskExitMessageThenServerTurnOff() {
        this.testServer("Exit", "");
    }

    /**
     * Проверить ответ сервера на другие фразы и выйти.
     */
    @Test
    public void whenAskHelloThenOracleAlsoGreets() {
        this.testServer(
                String.format("Hello Oracle%sExit", LN),
                String.format("Hello. I'm a Oracle.%s%s", LN, LN)
        );
    }

    /**
     * Check server response to other phrases and exit.
     */
    @Test
    public void whenUnsupportedAskThenOracleDontUnderstand() {
        this.testServer(
                Joiner.on(LN).join(
                        "Unsupported ask",
                        "Exit"
                ),
                Joiner.on(LN).join("I don't understand you.", "", "")
        );
    }
}
