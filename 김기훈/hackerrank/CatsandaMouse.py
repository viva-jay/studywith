#!/bin/python3

import math
import os
import random
import sys

# Complete the catAndMouse function below.
def catAndMouse(x, y, z):
    A_to_mouse = abs(x-z)
    B_to_mouse = abs(y-z)
    if A_to_mouse < B_to_mouse:
        return "Cat A"
    elif B_to_mouse < A_to_mouse:
        return "Cat B"
    else:
        return "Mouse C"


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        xyz = input().split()

        x = int(xyz[0])

        y = int(xyz[1])

        z = int(xyz[2])

        result = catAndMouse(x, y, z)

        fptr.write(result + '\n')

    fptr.close()
