#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'plusMinus' function below.
#
# The function accepts INTEGER_ARRAY arr as parameter.
#

def plusMinus(arr):
    positive_count = 0
    negative_count = 0
    zero_count = 0
    n = len(arr)
    for num in arr:
        if num == 0:
            zero_count += 1
        elif num > 0:
            positive_count += 1
        elif num < 0:
            negative_count += 1
    print("{:.6f}".format(positive_count / n))
    print("{:.6f}".format(negative_count / n))
    print("{:.6f}".format(zero_count / n))

if __name__ == '__main__':
    n = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    plusMinus(arr)
