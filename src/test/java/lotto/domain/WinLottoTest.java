package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinLottoTest {


    @Test
    public void 당첨_로또_생성() {
        List<Integer> winningNumber = List.of(1, 2, 3, 23, 34, 42);
        WinLotto winLotto = new WinLotto(winningNumber, 43);
        for (int i = 0; i < winLotto.getTicket().getNumbers().size(); i++) {
            assertThat(winLotto.getTicket().getNumbers().get(i)).isEqualTo(
                LottoNumber.from(winningNumber.get(i)));
        }
        assertThat(winLotto.getBonusNumber()).isEqualTo(LottoNumber.from(43));
    }

    @Test
    public void 보너스번호는_당첨번호에_포함_불가() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 23, 34, 42), 3)).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("보너스번호는 당첨번호에 포함될 수 없습니다.");
    }

    @Test
    public void 로또_당첨금액_계산() {
        WinLotto winLotto = new WinLotto(List.of(11, 22, 33, 38, 42, 44), 24);
        LottoTicket lottoTicket = LottoTicket.createTicket(List.of(11, 22, 33, 35, 38, 45));
        assertThat(winLotto.price(lottoTicket)).isEqualTo(LottoPrice.FOURTH);
    }

}
