#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'breakingRecords' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts INTEGER_ARRAY scores as parameter.
#

def breakingRecords(scores):
    min_count = max_count = 0
    min_value = max_value = -1
    for score in scores:
        if min_value == -1:
            min_value = score
            max_value = score
        else:
            if score > max_value:
                max_value = score
                max_count += 1
            if score < min_value:
                min_value = score
                min_count += 1
    return [max_count, min_count]

if __name__ == '__main__':
    #fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    scores = list(map(int, input().rstrip().split()))

    result = breakingRecords(scores)
    print(result)

    #fptr.write(' '.join(map(str, result)))
    #fptr.write('\n')

    #fptr.close()
