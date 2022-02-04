package ru.job4j.io.bot;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTest {
    private static final String LN = System.lineSeparator();

    /**
     * Заполняет входные данные и имитирует работу клиентской части бота.
     * Сравнивает выходные данные с ожидаемым результатом.
     *
     * @param input    данные
     * @param expected результат
     */
    private void testClient(String input, String expected) {
        Socket socket = mock(Socket.class);
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes())
        ) {
            when(socket.getInputStream()).thenReturn(in);
            when(socket.getOutputStream()).thenReturn(out);
            System.setIn(new ByteArrayInputStream(expected.getBytes()));
            Client client = new Client(socket);
            client.start();
            assertThat(out.toString(), is(expected));
            System.setIn(System.in);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Проверяйте, когда клиент приветствует и говорит «Exit».
     */
    @Test
    public void whenSendHalloThenReceivesAlsoGreets() {
        this.testClient(
                String.format("Hello, dear friend, I'm a oracle.%s%s", LN, LN),
                Joiner.on(LN).join(
                        "Hello oracle",
                        "Exit",
                        ""
                )
        );
    }

    /**
     * Проверить, когда клиент здоровается, говорит другие фразы и выходит.
     */
    @Test
    public void whenSendOtherMessageThenOracleDontUnderstand() {
        this.testClient(
                Joiner.on(LN).join(
                        "Hello, dear friend, I'm a oracle.",
                        "",
                        "I don't understand you.",
                        "",
                        ""
                ),
                Joiner.on(LN).join(
                        "Hello oracle",
                        "How're you?",
                        "Exit",
                        ""
                )
        );
    }
}
