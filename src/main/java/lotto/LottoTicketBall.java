package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketBall {

    private static final int START_TICKET_NUMBER = 1;
    private static final int END_TICKET_NUMBER = 45;
    private final List<Integer> balls = IntStream.rangeClosed(START_TICKET_NUMBER,
                    END_TICKET_NUMBER)
            .boxed().collect(Collectors.toList());

    public LottoTicket generateTicket() {
        Collections.shuffle(balls);
        List<Integer> inputs = balls.subList(0,6);
        LottoTicket ticket = new LottoTicket(inputs);
        return ticket;
    }

}

