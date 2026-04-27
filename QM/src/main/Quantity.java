package com.app.quantitymeasurement;

public class Quantity {

    // Inner class representing Feet
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            // Step 1: same reference
            if (this == obj) return true;

            // Step 2: null or different class
            if (obj == null || getClass() != obj.getClass()) return false;

            // Step 3: type casting
            Feet other = (Feet) obj;

            // Step 4: compare values safely
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Main method (for manual testing)
    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Are equal: " + f1.equals(f2));
    }
}