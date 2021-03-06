package tasks.solution;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import tasks.StreamTasks;
import tasks.utils.Box;
import tasks.utils.Item;

public class StreamTasksSolution extends StreamTasks {
    
    @Override
    public Set <String> task1 (List <String> names) {
        return Set.copyOf (names);
    }
    
    @Override
    public List <String> task2 (List <String> names) {
        return List.copyOf (Set.copyOf (names));
    }
    
    @Override
    public int task3 (List <String> names) {
        return task2 (names).size ();
    }
    
    @Override
    public List <Integer> task4 () {
        return List.of (0, 1, 2, 3, 4, 5, 6, 7);
    }
    
    @Override
    public Stream <String> task5 (List <String> names) {
        return names.stream ();
    }
    
    @Override
    public Stream <String> task6 (List <String> names) {
        return names.parallelStream ();
    }
    
    @Override
    public Stream <String> task7 (List <String> names) {
        return names.stream ().filter (Objects::nonNull);
    }
    
    @Override
    public Stream <String> task8 (List <String> names) {
        return names.stream ().map (n -> n + " Smith");
    }
    
    @Override
    public Stream <String> task9 (List <String> names) {
        return names.stream ().filter (Objects::nonNull).map (n -> n + " Smith");
    }
    
    @Override
    public Stream <String> task10 (List <String> names) {
        return names.stream ().sorted ();
    }
    
    @Override
    public Stream <String> task11 (List <String> names, Function <String, String> function) {
        return names.stream ().map (function);
    }
    
    @Override
    public Stream <String> task12 (List <String> names) {
        return names.stream ().distinct ();
    }
    
    @Override
    public Stream <Integer> task13 (List <String> numbers) {
        return numbers.stream ().map (Integer::parseInt);
    }
    
    @Override
    public Stream <Integer> task14 (List <String> numbers) {
        return numbers.stream ().map (Integer::parseInt).sorted ();
    }
    
    @Override
    public IntStream task15 (List <String> numbers) {
        return numbers.stream ().mapToInt (Integer::parseInt);
    }
    
    @Override
    public int task16 (List <String> numbers) {
        return task15 (numbers).sum ();
    }
    
    @Override
    public IntStream task17 () {
        return IntStream.range (0, 9933);
    }
    
    @Override
    public Stream <String> task18 (List <String> names, int streamLength) {
        return names.stream ().limit (streamLength);
    }
    
    @Override
    public Stream <String> task19 (List <String> names, int nameLength) {
        return names.stream ().filter (name -> name.length () == nameLength);
    }
    
    @Override
    public Stream <String> task20 (List <String> names, Comparator <String> comparator) {
        return names.stream ().filter (Objects::nonNull).sorted (comparator);
    }
    
    @Override
    public Stream <String> task21 (List <String> a, List <String> b) {
        return Stream.concat (a.stream (), b.stream ());
    }
    
    @Override
    public Stream <Integer> task22 (List <String> names, Map <String, Integer> name2value) {
        return names.stream ().map (name2value::get);
    }
    
    @Override
    public int task23 (List <String> names, Map <String, Integer> name2value) {
        return names.stream ().filter (name2value::containsKey).mapToInt (name2value::get).sum ();
    }
    
    @Override
    public Stream <Integer> task24 (List <Integer> numbers, int from, int to) {
        return IntStream.range (from, to + 1).mapToObj (numbers::get);
    }
    
    @Override
    public Stream <Integer> task25 (List <Integer> ns, int f1, int t1, int f2, int t2) {
        return IntStream.range (0, ns.size ()).filter (i -> (i >= f1 && i <= t1) || (i >= f2 && i <= t2)).mapToObj (ns::get);
    }
    
    @Override
    public boolean task26 (Stream <String> names, String name) {
        return names.anyMatch (name::equals);
    }
    
    @Override
    public int task27 (Stream <String> names, String name) {
        return (int) Math.max (names.dropWhile (n -> !name.equals (n)).count () - 1, 0);
    }
    
    @Override
    public Stream <String> task28 (List <String> ns, List <String> lns) {
        return IntStream.range (0, Math.min (ns.size (), lns.size ())).mapToObj (i -> String.format ("%s %s", ns.get (i), lns.get (i)));
    }
    
    @Override
    public List <String> task29 (Stream <String> names) {
        return names.collect (Collectors.toList ());
    }
    
    @Override
    public Set <String> task30 (Stream <String> names) {
        return names.collect (Collectors.toSet ());
    }
    
    @Override
    public List <Integer> task31 (Stream <Integer> numbers) {
        return numbers.limit (10).collect (Collectors.toList ());
    }
    
    @Override
    public List <List <String>> task32 (Stream <String> names) {
        return names.map (List::of).collect (Collectors.toList ());
    }
    
    @Override
    public List <List <List <String>>> task33 (Stream <String> names) {
        return names.map (List::of).map (List::of).collect (Collectors.toList ());
    }
    
    @Override
    public List <String> task34 (Stream <List <String>> namesGroups) {
        return namesGroups.flatMap (List::stream).collect (Collectors.toList ());
    }
    
    @Override
    public List <String> task35 (Stream <List <String>> namesGroups, String name) {
        return namesGroups.filter (grp -> grp.indexOf (name) != -1).flatMap (List::stream)
             . collect (Collectors.toList ());
    }
    
    @Override
    public int task36 (List <List <Integer>> matrix) {
        return (int) matrix.stream ().flatMap (List::stream).mapToInt (i -> i).sum ();
    }
    
    @Override
    public int task37 (List <List <Integer>> matrix) {
        return (int) IntStream.range (0, matrix.size ()).map (i -> matrix.get (i).get (i)).sum ();
    }
    
    @Override
    public int task38 (List <List <Integer>> matrix) {
        return (int) matrix.stream ().filter (row -> row.stream ().mapToInt (i -> i).sum () < 0).count ();
    }
    
    @Override
    public Stream <String> task39 (Stream <String> names) {
        return names.sorted (Comparator.reverseOrder ());
    }
    
    @Override
    public List <List <Integer>> task40 (List <Integer> numbers, int length) {
        return IntStream.range (0, (int) Math.ceil (numbers.size () * 1.0 / length))
             . mapToObj (i -> numbers.subList (i * length, Math.min (numbers.size (), (i + 1) * length)))
             . collect (Collectors.toList ());
    }
    
    @Override
    public List <List <Integer>> task41 (List <List <Integer>> numbers, int l, int c) {
        final var flat = IntStream.range (0, l * c).mapToObj (i -> numbers.get (l - i / c - 1).get (c - i % c - 1))
            . collect (Collectors.toList ());
        return task40 (flat, c);
    }
    
    @Override
    public List <List <Integer>> task42 (List <List <Integer>> numbers, int l, int c) {
        final var flat = IntStream.range (0, l * c).mapToObj (i -> numbers.get (i % c).get (i / c))
            . collect (Collectors.toList ());
        return task40 (flat, c);
    }
    
    @Override
    public Stream <String> task43 (
        Stream <String> names, Predicate <String> condition1, Predicate <String> condition2
    ) {
        final var condition = condition1.or (condition2);
        return names.filter (n -> n != null && condition.test (n));
    }
    
    @Override
    public int task44 (Supplier <Integer> generator, int number) {
        return Stream.generate (generator).limit (number).mapToInt (i -> i).sum ();
    }
    
    @Override
    public void task45 (Stream <String> numbers, Consumer <Integer> consumer) {
        numbers.map (str -> Integer.parseInt (str, 16)).sorted ().distinct ().forEach (consumer);
    }
    
    @Override
    public Predicate <String> task46 (List <Predicate <String>> predicates) {
        return predicates.stream ().reduce (Predicate::or).orElse (__ -> false);
    }
    
    @Override
    public boolean task47 (IntStream brackets) {
        return brackets.map (c -> c == '(' ? 1 : -1).reduce (0, (cur, d) -> cur + d < 0 ? Integer.MIN_VALUE : cur + d) == 0;
    }
    
    @Override
    public IntStream task48 (int length, Supplier <Integer> delta) {
        return IntStream.iterate (0, i -> i + delta.get ()).limit (length);
    }
    
    @Override
    public int task49 (ToIntFunction <Integer> c, int upperBound) {
        return Stream.iterate (new int [] {0, upperBound}, i -> i [1] - i [0] != 0, i -> {
            final int m = (i [1] + i [0]) / 2, rel = c.applyAsInt (m);
            return rel < 0 ? new int [] {m, i [1]} : (rel > 0 ? new int [] {i [0], m} : new int [] {m, m});
        }).map (arr -> (arr [0] + arr [1]) / 2).reduce ((a, b) -> b).orElse (upperBound / 2);
    }
    
    @Override
    public <T> Stream <T> task50 (List <T> values) {
        return Stream.iterate (0, i -> i + 1).map (i -> values.get (i % values.size ()));
    }
    
    @Override
    public IntStream task51 (List <Integer> n) {
        return Stream.iterate (new int [] {0, n.get (0)}, 
            i -> new int [] {i [0] + 1, i [1] + n.get (i [0] + 1)}
        ).limit (n.size ()).mapToInt (i -> i [1]);
    }
    
    @Override
    public Set <String> task52 (List <Item> items) {
        return items.stream ().map (Item::getBarcode).collect (Collectors.toSet ());
    }
    
    @Override
    public int task53 (List <Item> items, char category) {
        return (int) items.stream ().map (Item::getCategory).filter (c -> c == category).count ();
    }
    
    @Override
    public Map <Character, List <Item>> task54 (List <Item> items) {
        return items.stream ().collect (Collectors.groupingBy (Item::getCategory));
    }
    
    @Override
    public Map <Character, Map <String, List <Item>>> task55 (List <Item> items) {
        return items.stream ().collect (Collectors.groupingBy (Item::getCategory, Collectors.groupingBy (Item::getBarcode)));
    }
    
    @Override
    public Box task56 (Stream <Item> items) {
        return items.sequential ().reduce (new Box (), Box::addItem, (a, b) -> a);
    }
    
    @Override
    public Box task57 (Stream <Item> items) {
        return task56 (items);
    }
    
    @Override
    public Stream <Item> task58 (List <Box> boxes) {
        return boxes.stream ().map (Box::getItems).flatMap (List::stream);
    }
    
    @Override
    public Stream <Item> task59 (List <Box> boxes, double weightLimit) {
        return boxes.stream ().filter (box -> box.getItems ().stream ().map (Item::getWeight).allMatch (w -> w <= weightLimit))
             . map (Box::getItems).flatMap (List::stream);
    }
    
    @Override
    public void task60 (Stream <Item> items, double weightLimit, Box box) {
        final var weight = new AtomicReference <Double> (0.0);
        items.takeWhile (item -> weight.updateAndGet (w -> w + item.getWeight ()) <= weightLimit).forEach (box::addItem);
    }
    
}
