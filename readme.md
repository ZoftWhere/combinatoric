# ZoftWhere Combinatoric Library

Release v2.0.0 (2019-09-17)


## Features

### Features for Series

- [x] Calculate the sequence for the sequence of values
- [x] Calculate the sequence for the sequence of squared values
- [x] Calculate the sequence for the sequence of cubed values
- [x] Calculate the sequence for the sequence of polynomial values
- [x] Use of primitive data type for sequence
- [x] Use of arbitrary precision data type for sequence

### Features for Permutation

- [x] Manipulate index only zero-indexed permutation
- [x] Manipulate object-value linked to zero-indexed permutation
- [ ] Retrieve/restore permutation state

### Features for Combinations

(Still under development)


## Not implemented (Out of current library scope)
- [ ] Calculate the value of a negative integer power sequence
- [ ] Calculate the value of an infinite sequence


## Examples

### Example of Immutable Sequence

The sequence builder is an immutable factory as the sequence objects themselves are immutable builders.

``` kotlin
    sequence = Generator.primitiveSequence();
    series10 = sequence.length(10);
    series20 = sequence.length(20);
```

### Example for Sum of Series

The sequence builder allows the calculation of the sum of a sequence.

The sum `7 + 20 + 33 + ... 72`

`= 7 + ... + (7 + 13 x) + ... (7 + 13 * 5)`

``` kotlin
    // 237
    series = Generator.primitiveSequence()
        .base(7).increment(13).length(6).sum();
```

The sum `(9)^6 + (19)^6 + (29)^6 + ... (1009)^6`

`= (9)^6 + ... + (9 + 10 x)^6 + ... (9 + 10 * 100)^6`

``` kotlin
    // 15743225838776547541
    series = Generator.bigIntegerSequence()
        .base(9).increment(10).exponent(6).length(101).sum();
```

The sum `(1.1)^4 + (2.2)^4 + (3.3)^4 + ... + (1.1 + 1.1 n)^4 + ... (10312.5)^4`

`= (0.0)^4 + (1.1)^4 + (2.2)^4 + (3.3)^4 + ... + (1.1 * 9375)^4`

``` kotlin
    // 21211575295124816437.0000
    series = Generator.bigDecimalSequence()
        .base(0).increment(BigDecimal.valueOf(1.1)).exponent(4).length(9376).sum();
```


### Example for Permutation (index only)

To run through two permutations by changing the index 1 to the next value.
``` kotlin
    permutation = Generator.newPermutation(5);
    // [0, 1, 2, 3, 4]
    System.out.println(permutation);
    permutation = permutation.progress(1);
    // [0, 2, 1, 3, 4]
    System.out.println(permutation);
    permutation = permutation.progress(1);
    // [0, 3, 1, 2, 4]
    System.out.println(permutation);
```