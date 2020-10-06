# ZoftWhere Combinatoric Library
![Language](https://img.shields.io/github/languages/top/ZoftWhere/combinatoric)
[![License](https://img.shields.io/github/license/ZoftWhere/combinatoric)](https://github.com/ZoftWhere/combinatoric/blob/master/license.txt)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/ZoftWhere/combinatoric)
![GitHub Release Date](https://img.shields.io/github/release-date/ZoftWhere/combinatoric)
![GitHub last commit (branch)](https://img.shields.io/github/last-commit/ZoftWhere/combinatoric/master?label=master%20updated)

A combinatoric library.

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


## Compiling and Installing the Library

The source code can be compiled with Java language version 8.  It has been tested with Oracle JDK8, JDK11 and JDK12.  The test sources are compiled against JDK 11.

The project is Maven based, so executing the ```mvn install``` should install the library to the local repository (Requires at least JDK11).  It has been tested with Apache Maven v3.6.1.

The project will package the JavaDoc archive using JDK8 rules and styles.  The JavaDoc archive can be set to a later release by specifying the ```maven.compiler.main-jdk``` property.  For example, the JavaDoc will be packaged and installed for JDK11 by calling:

``` shell script
mvn clean install -Dmaven.compiler.main-jdk=11
```

If the project needs to be installed against JDK8, it can be accomplished by calling the following Maven command:

``` shell script
mvn clean compiler:compile@main-compile-jdk8 jar:jar@main-jar source:jar@main-sources javadoc:jar@main-javadoc-jdk8 moditect:add-module-info@main-jpms install:install-file@main-install
```


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

`= 7 + ... + (7 + 13 i) + ... (7 + 13 * 5)`

``` kotlin
    // 237
    series = Generator.primitiveSequence()
        .base(7).increment(13).length(6).sum();
```

The sum `(9)^6 + (19)^6 + (29)^6 + ... (1009)^6`

`= (9)^6 + ... + (9 + 10 i)^6 + ... (9 + 10 * 100)^6`

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

### More Examples

The source code for the [ZoftWhere Combinatoric Examples](https://github.com/ZoftWhere/combinatoric/tree/master/test-java/example), and more, are available for download [here](https://github.com/ZoftWhere/combinatoric/tree/master/test-java/example).


## License

Copyright (C) 2020 ZoftWhere

Licensed under the MIT License

------