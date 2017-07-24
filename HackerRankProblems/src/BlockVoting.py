def initialize_solution_set():
    solution_set = [0] * 1001
    return solution_set

def main():
    T = int(input())
    for i in range(T):
        temp = input().split(" ")
        party_members = []
        total_votes = 0
        for j in range(int(temp[0])):
            party_members.append(int(temp[j + 1]))
            total_votes += int(temp[j + 1])

        majority_votes = int(total_votes / 2) + 1

        for parties in range(len(party_members)):
            # remainder_votes = majority_votes - party_members[parties]
            solution_set = initialize_solution_set()
            solution_set[0] = 1
            for votes in range(len(party_members)):
                if parties == votes:
                    continue
                for x in range(majority_votes - party_members[votes], -1, -1):
                    solution_set[x + party_members[votes]] += solution_set[x]

            result = 0
            for y in range((majority_votes - party_members[parties]), majority_votes):
                if y >= 0:
                    result += solution_set[y]
            print("party " + str(parties + 1) + " has power index " + str(result))
        print()



if __name__ == '__main__':
    main()