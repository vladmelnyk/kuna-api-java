package io.kuna.model;


public class Ticker {

    private Long at;
    private InnerTicker ticker;

    public Long getAt() {
        return at;
    }

    public void setAt(Long at) {
        this.at = at;
    }

    public InnerTicker getTicker() {
        return ticker;
    }

    public void setTicker(InnerTicker ticker) {
        this.ticker = ticker;
    }

    @Override
    public String toString() {
        return "{" +
                "at=" + at +
                ", ticker=" + ticker +
                '}';
    }

    private static class InnerTicker {

        private Double buy;
        private Double sell;
        private Double low;
        private Double high;
        private Double last;
        private Double vol;

        public Double getBuy() {
            return buy;
        }

        public void setBuy(Double buy) {
            this.buy = buy;
        }

        public Double getSell() {
            return sell;
        }

        public void setSell(Double sell) {
            this.sell = sell;
        }

        public Double getLow() {
            return low;
        }

        public void setLow(Double low) {
            this.low = low;
        }

        public Double getHigh() {
            return high;
        }

        public void setHigh(Double high) {
            this.high = high;
        }

        public Double getLast() {
            return last;
        }

        public void setLast(Double last) {
            this.last = last;
        }

        public Double getVol() {
            return vol;
        }

        public void setVol(Double vol) {
            this.vol = vol;
        }

        @Override
        public String toString() {
            return "{" +
                    "buy=" + buy +
                    ", sell=" + sell +
                    ", low=" + low +
                    ", high=" + high +
                    ", last=" + last +
                    ", vol=" + vol +
                    '}';
        }
    }
}
