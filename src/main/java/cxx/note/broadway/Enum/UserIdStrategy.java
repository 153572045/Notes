package cxx.note.broadway.Enum;

public enum UserIdStrategy {
    PIN {
        @Override
        public String getUserId(String broadwayRequest) {
            return "broadwayRequest.getUser().getPin()";
        }
    },
    UUID {
        @Override
        public String getUserId(String broadwayRequest) {
            return "broadwayRequest.getUser().getUuid()";
        }
    },
    PIN_PRIO {
        @Override
        public String getUserId(String broadwayRequest) {
            String pin = "broadwayRequest.getUser().getPin()";
            return pin;
        }
    },
    UUID_PRIO {
        @Override
        public String getUserId(String broadwayRequest) {
            String uuid = "broadwayRequest.getUser().getUuid()";
            return uuid;
        }
    };

    /**
     * 返回userId.
     */
    public abstract String getUserId(String broadwayRequest);
}
