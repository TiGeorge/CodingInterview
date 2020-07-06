package stepik.problem_3_2_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    interface Organization {
        int getId();
    }

    public static void main(String[] args) {
        List<Organization> organizations = new ArrayList<>();

        Map<Integer, Organization> actual = organizations.stream()
                .collect(
                        Collectors.toMap(Organization::getId, o->o)
                );
    }

}
