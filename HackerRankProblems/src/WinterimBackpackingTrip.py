import sys

def solve_winterim(K, campsites):
    solution_set = []
    val = float('inf')
    for row in range(K + 1):
        solution_set += [[0] * (len(campsites) + 1)]
    for i in range(1, len(campsites) + 1):
        solution_set[0][i] = solution_set[0][i-1] + campsites[i - 1]
    for j in range(1, K + 1):
        for k in range(1, len(solution_set[0])):
            for l in range(1, k + 1):
                solution_set[j][k] = min(val, max(solution_set[j - 1][l], solution_set[0][k] - solution_set[0][l]))
                val = solution_set[j][k]
            solution_set[j][k] = val
            val = float('inf')
    print(solution_set[len(solution_set) - 1][len(solution_set[0]) - 1])

def main():
    while True:
        line = sys.stdin.readline()
        if (line == "") or (line == "\n") or (line is None):
            break
        if len(line) > 1:
            line = line.split(" ")
            N = int(line[0])
            K = int(line[1])
            campsites = []
            for i in range(N + 1):
                campsites.append(int(input()))
        else:
            break
        solve_winterim(K, campsites)
    print()



if __name__ == '__main__':
    main()