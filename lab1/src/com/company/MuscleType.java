package com.company;

public enum MuscleType {
    Biceps {
        @Override
        public String toString() {
            return "Biceps";
        }
    },
    Triceps{
        @Override
        public String toString() {
            return "Triceps";
        }
    },
    Forearm{
        @Override
        public String toString() {
            return "Forearm";
        }
    },
    Chest{
        @Override
        public String toString() {
            return "Chest";
        }
    },
    Shoulders{
        @Override
        public String toString() {
            return "Shoulders";
        }
    },
    Back{
        @Override
        public String toString() {
            return "Back";
        }
    },
    Hip{
        @Override
        public String toString() {
            return "Hip";
        }
    }, // бедро
    Abdominis{
        @Override
        public String toString() {
            return "Abdominis";
        }
    }, //прес
    Gastrocnemius{
        @Override
        public String toString() {
            return "Gastrocnemius";
        }
    }, // ікра
    Cardio{
        @Override
        public String toString() {
            return "Cardio";
        }
    };

}
