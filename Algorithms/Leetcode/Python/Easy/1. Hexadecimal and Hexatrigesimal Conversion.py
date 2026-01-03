class Solution:
    def concatHex36(self, n):

        def to_base36(decimal_num):
            if decimal_num == 0:
                return 0
            
            BASE36_CHARS = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
            base = 36
            result = ""

            while decimal_num > 0:
                remainder = decimal_num % base
                result = BASE36_CHARS[remainder] + result
                decimal_num //= base

            return result
        
        n_squared = n ** 2
        n_cubed = n ** 3

        hex_part = hex(n_squared)[2:].upper()
        base36_part = to_base36(n_cubed)
    
        return hex_part + base36_part

def main():
    n = 13
    sol = Solution()
    print(sol.concatHex36(n))

if __name__ == "__main__":
    main()