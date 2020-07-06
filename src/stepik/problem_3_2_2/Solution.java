package stepik.problem_3_2_2;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Solution {

    Stream<String> uniqueNameStream(Stream<Organization> organizationStream) {
        //enter your code


        return organizationStream.filter(o->o.getWorkers().size()>7)
                .flatMap(organization -> organization.getWorkers().stream())
                .map(worker -> worker.getName())
                .distinct();
    }

    interface Organization {
        List<Worker> getWorkers();
    }

    interface Worker {
        String getName();
    }

}
