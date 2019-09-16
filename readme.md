# ZoftWhere Combinatoric Library

Release v1.0.0 (2019-09-15)


## Features

### Features for Series

- [x] Calculate the sum of a linear series
- [x] Calculate the sum of a square series
- [x] Calculate the sum of a cube series
- [x] Calculate the sum of a positive integer power series
- [x] Use of primitive data type for series
- [x] Use of arbitrary precision data type for series

### Features for Permutation

- [x] Manipulate index only zero-indexed permutation
- [x] Manipulate object-value linked to zero-indexed permutation
- [ ] Retrieve/restore permutation state

### Features for Combinations

(Still under development)


## Not implemented (Out of current library scope)
- [ ] Calculate the value of a negative integer power series
- [ ] Calculate the value of an infinite series


## Examples

### Example for Sum of Series

The sum `7 + 20 + 33 + ... + (7 + 13 n) + ... 72 = 237`
``` kotlin
// 237
SeriesBuilder.primitiveSeries()
    .base(7).increment(13).length(6).sum();
```

The sum `(9)^6 + (19)^6 + (29)^6 + ... + (9 + 10 n)^6 + ... (1009)^6`
``` kotlin
// 15743225838776547541
SeriesBuilder.bigIntegerSeries()
    .base(9).increment(10).exponent(6).length(101).sum();
```

The sum `(1.1)^4 + (2.2)^4 + (3.3)^4 + ... + (0 + 1.1 n)^4 + ... (10312.5)^4`

`= (0.0)^4 + (1.1)^4 + (2.2)^4 + (3.3)^4 + ... + (1.1 * 9375)^4`

``` kotlin
// 21211575295124816437.0000
SeriesBuilder.bigDecimalSeries()
    .base(0).increment(BigDecimal.valueOf(1.1)).exponent(4).length(9376).sum();
```

### Example for Permutation (index only)

To run through two permutations by changing the index 1 to the next value.
``` kotlin
// [0, 1, 2, 3, 4]
permutation = PermutationBuilder.create(5);
// [0, 2, 1, 3, 4]
permutation = permutation.next(1);
// [0, 3, 1, 2, 4]
permutation = permutation.next(1);
```