package a_test;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        CourseLevel courseLevel = null;
        aa(courseLevel);
        System.out.println("a");

    }


    public static boolean aa(CourseLevel courseLevel) {
        if (courseLevel == null) {
            courseLevel = new CourseLevel();
            courseLevel.setCityCode("010");
        }
        return true;
    }


    public static class CourseLevel {
        private String studentId;
        private String cityCode;

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }
    }


}
