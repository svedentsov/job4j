package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator =  new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);

        Comparator<Attachment> comparatorName = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        attachments.sort(comparatorName);
        System.out.println(attachments);
    }
}
