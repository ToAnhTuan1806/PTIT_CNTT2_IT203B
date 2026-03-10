package baitap;

import java.util.List;
import java.util.stream.Collectors;

public class ex6 {
    public static void main(String[] args) {
        List<Post> posts = List.of(
                new Post("Java", List.of("java", "backend")),
                new Post("Python", List.of("python", "data"))
        );
        List<String> allTags = posts.stream().flatMap(post -> post.tags().stream())
                .collect(Collectors.toList());

        System.out.println(allTags);
    }
}
