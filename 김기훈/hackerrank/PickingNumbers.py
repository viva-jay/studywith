#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'pickingNumbers' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY a as parameter.
#

def pickingNumbers(a):
    digit_counter = [0 for i in range(101)]
    for digit in a:
        digit_counter[digit] += 1

    distance = 1
    max_length = 0
    for i in range(1, 100 - distance):
        if max_length < sum(digit_counter[i:i+distance+1]):
            max_length = sum(digit_counter[i:i+distance+1])
    return max_length


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    a = list(map(int, input().rstrip().split()))

    result = pickingNumbers(a)

    fptr.write(str(result) + '\n')

    fptr.close()
