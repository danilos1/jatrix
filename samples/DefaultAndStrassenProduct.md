# Comparison of default and Strassen's product of two matrices

| Benchmark | (N) | Mode | Cnt | Score | Error | Units |
| --------- |:----|:-----|:----|:------|:------|:------|
| MultiplyingBenchmarking.defaultMultiplicationBenchmark  |   32 | avgt | 15 |       39,620 ± |      5,724 | us/op |
| MultiplyingBenchmarking.defaultMultiplicationBenchmark  |  256 | avgt | 15 |    28831,850 ± |   7211,898 | us/op |
| MultiplyingBenchmarking.defaultMultiplicationBenchmark  |  512 | avgt | 15 |   289936,771 ± |  54475,469 | us/op |
| MultiplyingBenchmarking.defaultMultiplicationBenchmark  | 1024 | avgt | 15 |  6830310,373 ± | 420264,375 | us/op |
| MultiplyingBenchmarking.StrassenProductBenchmark        |   32 | avgt | 15 |       39,705 ± |     10,078 | us/op |
| MultiplyingBenchmarking.StrassenProductBenchmark        |  256 | avgt | 15 |    21517,058 ± |   4850,632 | us/op |
| MultiplyingBenchmarking.StrassenProductBenchmark        |  512 | avgt | 15 |   149734,647 ± |  12769,293 | us/op |
| MultiplyingBenchmarking.StrassenProductBenchmark        | 1024 | avgt | 15 |  1096859,417 ± | 102892,844 | us/op |

---
