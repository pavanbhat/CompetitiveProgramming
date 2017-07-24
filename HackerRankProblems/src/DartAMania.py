import math

def main():
    result = ""
    target_values = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 24, 26, 27, 28,
                     30, 32, 33, 34, 36, 38, 39, 40, 42, 45, 48, 50, 51, 54, 57, 60]
    dart_values = []
    for i in range(len(target_values)):
        dart_values.append(target_values[i])
        dart_values.append(target_values[i])
        dart_values.append(target_values[i])

    while True:
        val = int(input())
        if val <= 0:
            result += "END OF OUTPUT";
            break
        else:
            c_result = 0
            p_result = 0
            count = 1
            for i in range(len(dart_values) - 2):
                if dart_values[i] == dart_values[i - 1]:
                    continue
                pivot_a = i + 1
                pivot_b = len(dart_values) - 1
                while True:
                    if pivot_a >= pivot_b:
                        break
                    if dart_values[i] + dart_values[pivot_a] + dart_values[pivot_b] == val:
                        count_i = [dart_values[i], dart_values[pivot_a], dart_values[pivot_b]].count(dart_values[i])
                        count_a = [dart_values[i], dart_values[pivot_a], dart_values[pivot_b]].count(
                            dart_values[pivot_a])
                        if count_i == 3:
                            count = 3
                        elif count_i == 2 or count_a == 2:
                            count = 2
                        p_result += int(math.factorial(3) / math.factorial(count))
                        c_result += 1

                        while pivot_a < pivot_b and dart_values[pivot_a] == dart_values[pivot_a + 1]:
                            pivot_a += 1
                        while pivot_a < pivot_b and dart_values[pivot_b] == dart_values[pivot_b - 1]:
                            pivot_b -= 1

                        pivot_a += 1
                        pivot_b -= 1

                    elif dart_values[i] + dart_values[pivot_a] + dart_values[pivot_b] < val:
                        pivot_a += 1
                    else:
                        pivot_b -= 1
                    count = 1

            if c_result == 0:
                result += "THE SCORE OF " + str(val) + " CANNOT BE MADE WITH THREE DARTS." + "\n"
            else:
                result += "NUMBER OF COMBINATIONS THAT SCORES " + str(val) + " IS " + str(c_result) + "." +"\n" + "NUMBER OF PERMUTATIONS THAT SCORES " + str(val) + " IS " + str(p_result) + "." + "\n"

            result += "**********************************************************************" + "\n"
    print(result)


if __name__ == '__main__':
    main()