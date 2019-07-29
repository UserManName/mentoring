package com.mentoring.testing;

import java.util.Random;

public class Entity {
        private String name;
        private Integer value = new Random().nextInt();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }