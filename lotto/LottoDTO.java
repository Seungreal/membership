package lotto;

public class LottoDTO {
    private int countLimit,lottoCount;
    private int[] lotto;
    private int[][] lottos;
    
    public int getCountLimit() {
        return countLimit;
    }
    public void setCountLimit(int countLimit) {
        this.countLimit = countLimit;
    }
    public int getLottoCount() {
        return lottoCount;
    }
    public void setLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }
    public int[] getLotto() {
        return lotto;
    }
    public void setLotto(int[] lotto) {
        this.lotto = lotto;
    }
    public int[][] getLottos() {
        return lottos;
    }
    public void setLottos(int[][] lottos) {
        this.lottos = lottos;
    }
}
