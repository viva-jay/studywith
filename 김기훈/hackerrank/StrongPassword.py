#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'minimumNumber' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. STRING password
#

def minimumNumber(n, password):
    numbers = "0123456789"
    lower_case = "abcdefghijklmnopqrstuvwxyz"
    upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    special_characters = "!@#$%^&*()-+"

    numbers_ok = False
    lower_case_ok = False
    upper_case_ok = False
    special_characters_ok = False

    missing_character = 0
    for c in password:
        if numbers_ok is False and c in numbers:
            numbers_ok = True
        if lower_case_ok is False and c in lower_case:
            lower_case_ok = True
        if upper_case_ok is False and c in upper_case:
            upper_case_ok = True
        if special_characters_ok is False and c in special_characters:
            special_characters_ok = True
    if numbers_ok is False:
        missing_character += 1
    if lower_case_ok is False:
        missing_character += 1
    if upper_case_ok is False:
        missing_character += 1
    if special_characters_ok is False:
        missing_character += 1

    return max(6 - n, missing_character)


if __name__ == '__main__':
    #fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    password = input()

    answer = minimumNumber(n, password)
    print(answer)
    #fptr.write(str(answer) + '\n')

    #fptr.close()
