import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleStackTest {
    private SimpleStack stack;
    private static int totalPushes;

    @BeforeAll
    static void initAll() {
        totalPushes = 0;
        System.out.println(" Запуск всех тестов SimpleStack. Счетчик инициализирован: " + totalPushes);
    }

    @BeforeEach
    void setUp() {
        stack = new SimpleStack();
        System.out.println("   Создан новый пустой стек");
    }

    @AfterEach
    void tearDown() {
        System.out.println("   Текущее значение счетчика totalPushes: " + totalPushes);
        // В реальном проекте здесь можно было бы очищать ресурсы
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println(" Все тесты завершены. Общее количество добавлений: " + totalPushes);
    }

    @Test
    @DisplayName("Задание 1: Новый стек должен быть пустым")
    void testNewStackIsEmpty() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        System.out.println(" Выполняется testNewStackIsEmpty");
    }


    @Test
    @DisplayName("Задание 2.1: Добавление одного элемента")
    void testPushOneElement() {
        stack.push(42);

        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
        System.out.println("  Выполняется testPushOneElement");
    }
    @Test
    @DisplayName("Задание 2.2: Проверка принципа LIFO")
    void testLifoPrinciple() {
        stack.push(10);
        stack.push(20);

        int popped = stack.pop();

        assertEquals(20, popped);
        assertEquals(1, stack.size());
        System.out.println("  Выполняется testLifoPrinciple");
    }

    @Test
    @DisplayName("Задание 3.1: Проверка увеличения счетчика при push")
    void testTotalPushesIncrement() {
        int beforePushes = totalPushes;
        stack.push(5);
        totalPushes++;
        assertEquals(beforePushes + 1, totalPushes);
        System.out.println("   Выполняется testTotalPushesIncrement");
    }

    @Test
    @DisplayName("Задание 3.2: Множественные push")
    void testMultiplePushes() {
        int beforePushes = totalPushes;
        int pushCount = 3;
        stack.push(1); totalPushes++;
        stack.push(2); totalPushes++;
        stack.push(3); totalPushes++;
        assertEquals(beforePushes + pushCount, totalPushes);
        assertEquals(3, stack.size());
        System.out.println("  Выполняется testMultiplePushes");
    }

    @Test
    @DisplayName("Задание 3.3: pop не влияет на счетчик")
    void testPopDoesNotAffectCounter() {
        stack.push(100);
        totalPushes++;
        int beforePushes = totalPushes;
        int popped = stack.pop();
        assertEquals(beforePushes, totalPushes);
        assertEquals(100, popped);
        System.out.println("   Выполняется testPopDoesNotAffectCounter");
    }

    @Test
    @DisplayName("Задание 3.4: Исключение при pop из пустого стека")
    void testPopFromEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.pop());
        assertEquals(0, stack.size());
        System.out.println(" Ы Выполняется testPopFromEmptyStack");
    }
}