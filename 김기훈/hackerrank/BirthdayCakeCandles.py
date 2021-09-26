#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'birthdayCakeCandles' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY candles as parameter.
#

def birthdayCakeCandles(candles):
    tallest_candle_height = 0
    tallest_candle_count = 0
    for candle in candles:
        if candle > tallest_candle_height:
            tallest_candle_height = candle
            tallest_candle_count = 1
        elif candle == tallest_candle_height:
            tallest_candle_count += 1

    return tallest_candle_count

if __name__ == '__main__':
    #fptr = open(os.environ['OUTPUT_PATH'], 'w')

    candles_count = int(input().strip())

    candles = list(map(int, input().rstrip().split()))

    result = birthdayCakeCandles(candles)

    #fptr.write(str(result) + '\n')

    #fptr.close()
