class Solution:
    def convertTime(self, current, correct):
        h1, m1 = map(int,current.split(":"))
        current_m = (60 * h1) + m1

        h2, m2 = map(int,correct.split(":"))
        correct_m = (60 * h2) + m2

        diff = correct_m - current_m
        operations = 0

        operations += diff//60
        diff %= 60

        operations += diff//15
        diff %= 15

        operations += diff//5
        diff %= 5

        operations += diff

        return operations
        
def main():
    current = "11:01"
    correct = "12:00"
    sol = Solution()
    print(sol.convertTime(current, correct))

if __name__ == "__main__":
    main()