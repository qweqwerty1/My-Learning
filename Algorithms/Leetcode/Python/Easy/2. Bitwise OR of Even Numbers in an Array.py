class Solution:
    def evenNumberBitwiseORs(self, nums):
        result = 0
        for i in nums:
            if i % 2 == 0:
                result |= i
        return result

def main():


if __name__ == "__main__":
    main()