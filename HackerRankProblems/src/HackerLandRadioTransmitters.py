#!/bin/python3

import sys

def main():
    n, k = input().strip().split(' ')
    n, k = [int(n), int(k)]
    x = [int(x_temp) for x_temp in input().strip().split(' ')]
    x.sort()
    position = 0
    count = 0
    while True:
        if position >= n:
            break
        count += 1
        transmitter_position = x[position] + k
        while position < n and x[position] <= transmitter_position:
            position += 1
            if position >= n:
                break
        position -= 1
        transmitter_position = x[position] + k
        while position < n and x[position] <= transmitter_position:
            position += 1
            if position >= n:
                break
    print(count)


if __name__ == '__main__':
    main()