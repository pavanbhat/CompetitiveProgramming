def initialize_solution_set():
    solution_set = [0] * 25000
    return solution_set

def main():
    T = int(input())
    for t in range(T):
        solution_set = initialize_solution_set()
        # solution_set[0] = 0
        number_of_coins = int(input())
        value_of_coins = input().split()
        total_value = sum(int(k) for k in value_of_coins)
        # if total_value % 2:
        #     share = int(total_value / 2)
        # else:
        #     share = int((total_value - 1) / 2)
        share = int(total_value / 2)
        try:
            for i in range(1, number_of_coins + 1):
                for j in range(share, 0, -1):
                    if j >= int(value_of_coins[i - 1]):
                        solution_set[j] = max(solution_set[j], (solution_set[j - int(value_of_coins[i - 1])] + int(value_of_coins[i - 1])))
        except Exception as e:
            print(e)
        print(total_value - (solution_set[share] * 2))
    print()



if __name__ == '__main__':
    main()