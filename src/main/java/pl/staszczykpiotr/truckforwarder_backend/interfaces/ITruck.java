package pl.staszczykpiotr.truckforwarder_backend.interfaces;

public interface ITruck {

        public Integer getID();
        public String getName();
        public String getLoading();
        public Float getLength();
        public Float getWidth();
        public Float getHeight();
        public Float getWeight();
        public Float getCapacity();
        public Float getPrice();
        public Byte getStatus();
    }

