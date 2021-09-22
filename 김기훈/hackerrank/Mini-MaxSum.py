#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'miniMaxSum' function below.
#
# The function accepts INTEGER_ARRAY arr as parameter.
#

def miniMaxSum(arr):
    min_value = sum_value = sum(arr)
    max_value = 0

    for num in arr:
        if sum_value - num < min_value:
            min_value = sum_value - num
        if sum_value - num > max_value:
            max_value = sum_value - num
    print("{} {}".format(min_value, max_value))


if __name__ == '__main__':

    arr = list(map(int, input().rstrip().split()))

    miniMaxSum(arr)
