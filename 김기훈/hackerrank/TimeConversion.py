#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'timeConversion' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def timeConversion(s):
    hour = int(s[:2])
    period = s[-2:]

    if period == "AM":
        return str((hour + 12) % 12).rjust(2, '0') + s[2:-2]
    elif period == "PM":
        return str((hour % 12) + 12).rjust(2, '0') + s[2:-2]
    return 0

if __name__ == '__main__':
    #fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = timeConversion(s)
    print(result)

    #fptr.write(result + '\n')

    #fptr.close()
