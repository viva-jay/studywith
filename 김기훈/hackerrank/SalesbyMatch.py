#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'sockMerchant' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER_ARRAY ar
#

def sockMerchant(n, ar):
    sock_counter = {}
    for sock_color in ar:
        sock_counter[sock_color] = sock_counter[sock_color] + 1 if sock_color in sock_counter else 1
    pair_count = 0;
    for sock_color, count in sock_counter.items():
        if count >= 2:
            pair_count += count // 2
    return pair_count

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    ar = list(map(int, input().rstrip().split()))

    result = sockMerchant(n, ar)

    fptr.write(str(result) + '\n')

    fptr.close()
