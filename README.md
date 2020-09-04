# Jatrix

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/danilos1/jatrix/blob/master/LICENSE)
[![Maven Central](https://img.shields.io/badge/maven%20central-0.1-green)](https://search.maven.org/artifact/com.github.danilos1/jatrix/0.1/jar)


<p align="center">
  <img src="https://github.com/danilos1/jatrix/blob/master/images/logo.png"/>
</p>


## A poweful library for performing different operations with matrices

Hi there! Jatrix is a new library for performing different operations with matrices. There are some operations with matrices: summation, subtraction, multiplying, trasposition, inversion, solving a system of linear equations, decompostitions, etc. The library is focused on performance and simplicity. In the [benchmarking](https://github.com/danilos1/jatrix/tree/master/src/main/java/benchmarking) package you find benchmarks of some solutions.
<hr>

## Download

To download the library you need to use the following dependencies:
- Apache Maven:
```
  <dependency>
    <groupId>com.github.danilos1</groupId>
    <artifactId>jatrix</artifactId>
    <version>0.1</version>
  </dependency>
```
- Gradle Groovy DSL:
```implementation 'com.github.danilos1:jatrix:0.1'```

The ```Jatrix API``` is consisted of the following sections:

<p align="center">
  <img src="https://github.com/danilos1/jatrix/blob/master/images/api.png"/>
</p>

- ```core``` section is basic package, stores main classes of the library such as ```Matrix```, ```Matrices```, ```MatrixIterator``` etc.
 
 For instance, let's initialize some matrix and perform matrix product:
 
 ``` 
 Matrix a = new Matrix(new double[][]{
      { 1, 7, 3},
      {-5, 0, 9}
 });
     
 Matrix b = new Matrix(new double[][]{
      {8, 10},
      {3,-12},
      {1, -7},
 });
     
Matrix result = Matrices.mul(a, b);
System.out.println(result.prettyOut());
```
     
- ```exceptions``` section includes exceptions of the library.
- In ```solvers``` section you'll find a tools for solving linear equations.

To demonstrate one of solvers, let's solve the following system of linear equation:
  
   { -5*x1 + 3*x2 - x3 = 1<br>
   { 8*x2 + 2*x3 = -5<br>
   { 12*x1 + 7*x2 - 6*x3 = 6
   
   ```
   Matrix coefficients = new Matrix(new double[][]{
      { -5, 3, -1 },
      {  0, 8,  2 },
      { 12, 7, -6 },
   });
   
   double[] b = {1, -5, 6};
   
   CramerSolver solver = new CramerSolver(coefficients, b);
   System.out.println(solver);
   ```
   
- ```decompositions``` sections is used for decomposing some matrix (See [Matrix decomposition](https://en.wikipedia.org/wiki/Matrix_decomposition))

For example, let's decompose the matrix above:

```
  Matrix a = new Matrix(new double[][]{
      { -5, 3, -1 },
      {  0, 8,  2 },
      { 12, 7, -6 },
   });
   
   LUDecomposition lu = new LUDecomposition(a);
   System.out.println(lu.getL());
   System.out.println(lu.getU());
   System.out.println(lu.det());
```

- ```converse``` block is used for changing a matrix somewise (swap matrix rows or columns, etc)
- To find out some statistics such as maximum or minimum by row or column you can use ```statistics``` section.

For detail information you should go to the [Documentation](#docs) page.

## Features

There are some features of Jatrix library:
- A straightforward API.
- Strassen multiplying (more faster than default matrix product, you can see the result of comparison at [samples](https://github.com/danilos1/jatrix/blob/master/samples/) directory
  of the matrix multiplications).
- Comfortable output methods. Printing out to markdown or text file in a pretty form.   
- A vast numbers of methods for enjoyable development.

## <a name="docs">Documentation</a>

All ```Jatrix API``` is stored in [JavaDoc](https://github.com/danilos1/jatrix/blob/master/docs/).

## License

Jatrix code is under [MIT License](https://github.com/danilos1/jatrix/blob/master/LICENSE)
