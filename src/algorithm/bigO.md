# Big-O?

최악의 복잡도를 계산하는 알고리즘. 복잡도를 계산하여 알고리즘의 성능을 표현한다.

Big-O에는 "시간복잡도" 와 "공간복잡도"가 존재한다.
- 시간 복잡도 : 입력 크기에 따른 알고리즘 실행 시간의 증가 속도를 나타낸다. 시간복잡도가 낮을수록 알고리즘의 성능이 좋다고 볼 수 있다.
  <br>(예를 들어, O(n)은 입력 크기 n에 비례하여 알고리즘의 실행 시간이 선형적으로 증가한다는 것을 의미하고, O(n²)는 입력 크기의 제곱에 비례하여 실행 시간이 증가한다는 것을 나타낸다.)
- 공간 복잡도 : 알고리즘이 사용하는 메모리 공간의 증가 속도를 나타낸다. 공간복잡도가 낮을수록 더 효율적인 알고리즘이라고 볼 수 있다.

정말 단순히 생각한다면 작업을 수행하는 횟수라고 볼 수 있다. 아래와 같은 경우는 O(n)이 소요된다.

```jsx
public class Main {

    public static void printItems(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        printItems(10);
    }
}
```

## 복잡도 종류
복잡도는 크게 4가지로 나누어 볼 수 있다.

- O(n²)
- O(n)
- O(log n)
- O(1)

![big-0.png](..%2Fimage%2Fbig-0.png)

## O(n)

```java
public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
        System.out.println(i);
    }
    for (int j = 0; j < n; j++) {
        System.out.println(j);
    }
}
```

for 문이 두 번 생성되어있기 때문에 O(2n) 이라고 생각할 수 있지만, 이것은 **O(n)**이다.

**Big-O role 1.**  n앞에 붙는 상수는 제거하고 생각한다.


## O(n²)

```java
public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println(i + "" + j);
        }
    }
}
```

이렇게 중첩될 경우 n제곱의 시간 복잡도가 소요된다.

→ n 값으로 10 을 넘겼을 경우, 100개가 반환됨. <br>
→ n * n = **n^2** <br>
→ **O(n^2)** 이 됨.

그렇다면 만약 이런 경우는 어떻게 될까?

```java
public static void printItems(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println(i + "" + j);
        }
    }
    for (int k = 0; k < n; k++) {
        System.out.println(k);
    }
}
```

이 경우라면 O(n² + n) 이 된다. 그러나 n² 에 비해 n은 너무나 작아서 영향도가 미미하므로, 최악의 상황을 추론하는 빅오에서는 이런 영향력이 적은 항은 제외하고 생각한다.

→ O(n² + n) <br>
→ **O(n²)** 이 됨. <br>

**Big-O role 2.** 영향력이 미미한 항은 제외한다.

## O(1)

**가장 효율적인 방법**.

```java
public static void printItems(int n) {
    return n + n;
}
```

n 과 n 을 더하는 하나의 작업을 한다.

→ **O(1)**

```java
public static void printItems(int n) {
    return n + n + n;
}
```

n 과 n 을 더하는 작업을 한다. <br>
더해진 값과 n 을 더하는 작업을 한다.

→ O(2) <br>
→ O(1)

**단순화하여 빅오를 계산한다.**

파라미터로 주어지는 n 이 얼마든지 작업의 횟수는 변하지 않으므로 항상 O(1) 이 걸린다.

→ **가장 효율적인 방법!**

## O(log N)

log N 을 구현하는 기본적인 방식.

💡 {1, 2, 3, 4, 5, 6, 7, 8} 인 배열이 주어졌다.
해당 배열에서 1을 찾으려고 한다면 어떻게 해야 할까? 💡

1. 배열을 정렬한다.
2. 배열을 반으로 나누어 어느 쪽에 1이 속해있을지 찾는다.
    1. **{1, 2, 3, 4}** {5, 6, 7, 8} - (1)
3. 1이 속해있다고 예상되는 배열을 다시 반으로 나눈다.
    1. **{1, 2}** {3, 4} - (2)
4. 1만 남는다.
    1. **{1} -** (3)

위 예제에서 1을 찾기 위해 총 3번의 나눔 과정이 소요되었다.

2³ = 8이다.

즉, logN 에서 N 은 주어진 수에 대한 2의 제곱근이라고 볼 수 있다.

→ 2의 몇 제곱이 8 인가? = 3 <br>
→ log3 의 복잡도가 소요됨. <br>
2³ == 8 , log(2)₈ == 3
8을 2로 몇 번 나누어야 1이 나오는가? == 2의 몇 제곱이 8인가?

→ 이게 logN 을 구하는 기본적인 방법이다.

<br>

---

## 배열과 빅오

- .remove() 는 제일 뒤에 있는 요소 하나를 제거하는 것이므로 O(1) 이 수행.
- .add() 는 제일 뒤에 요소 하나를 삽입하는 것이므로 O(1) 이 수행.
- .add(i, n) 는 특정 인덱스 자리에 요소를 삽입하는 과정이므로, 요소 삽입 후 인덱스 정렬까지 필요하게 되어 O(n) 이 수행.
- 배열에서 특정 값을 찾을 경우, 처음부터 끝까지 배열을 훑기때문에 O(n) 이 수행.
- 인덱스로 값을 찾을 경우, O(1) 이 수행.

Rule 1: Always worst Case

Rule 2: Remove Constants

Rule 3: Different inputs should have different variables/ 0(a+b). A and B arrays nested would be 0(a*b)

- for steps in order(순서대로 다 더하고)
- for nested steps(중첩된 반복문 곱하기)

Rule 4: Drop non-dominant terms

<br>

효율적으로 코드를 구성해야하는 이유를 복잡도를 가지고 살펴보자.

n = 100 일 때,
![big-o loop1 복사본.png](..%2Fimage%2Fbig-o%20loop1%20%EB%B3%B5%EC%82%AC%EB%B3%B8.png)

n = 1000 일 때,
![big-o loop2 복사본.png](..%2Fimage%2Fbig-o%20loop2%20%EB%B3%B5%EC%82%AC%EB%B3%B8.png)

logN 은 7 → 10 으로 3 증가했지만, O(n)과 O(n^2)은 각각 1000, 100000 으로 증가되어 logN에 비해 엄청나게 큰 증가량을 확인할 수 있다.

얼마나 많은 과정을 수행하는 지를 단순하게 생각하기 보단, 미치게 될 증가량을 생각해보면 효율적인 복잡도에 대 중요성을 더 느낄 수 있다.
![big-o loop3 복사본.png](..%2Fimage%2Fbig-o%20loop3%20%EB%B3%B5%EC%82%AC%EB%B3%B8.png)


<br>
(+ 빅오 차트에서 각 알고리즘에서 소요되는 빅오는 얼마인지 등등, 자세한 내용을 확인해볼 수 있다.
https://www.bigocheatsheet.com/)