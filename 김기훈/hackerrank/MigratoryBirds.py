#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'migratoryBirds' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#

def migratoryBirds(arr):
    count_arr = [0,0,0,0,0,0]
    max_value = -1
    for a in arr:
        count_arr[a] = count_arr[a] + 1
        if count_arr[a] > max_value:
            max_value = count_arr[a]

    for a in range(0,6):
        if count_arr[a] == max_value:
            return a
    return 1

if __name__ == '__main__':
    #fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr_count = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    result = migratoryBirds(arr)

    #fptr.write(str(result) + '\n')

    #fptr.close()
