import sys

class Solution:
    def findWordsContaining(self, words, x):
        return [i for i in range(len(words)) if x in words[i]]

def validate_word(word):
    if not(1 <= len(word) <= 50 and word.isalpha() and word.islower()):
        raise ValueError(f"'{word}'는 유효한 단어가 아닙니다.")
    
def validate_char(char):
    if not(len(char) == 1 and char.isalpha() and char.islower()):
        raise ValueError(f"'{char}'는 유효한 검색 문자가 아닙니다.")
    
def validate_n(n):
    if not(1<=len(n)<=50 and n.isdigit()):
        raise ValueError(f"{n}은(는) 유효한 개수가 아닙니다.")

def main():
    try:
        n_str = input("단어의 개수를 입력하세요: ").strip()
        validate_n(n_str)
        n = int(n_str)
        words = []
        print(f"{n}개의 단어를 한 줄에 하나씩 입력하세요:")
        for _ in range(n):
            word = input().strip()
            validate_word(word)
            words.append(word)

        x = input("검색할 한 개의 소문자를 입력하세요: ").strip()
        validate_char(x)

        solution = Solution()
        result = solution.findWordsContaining(words, x)
        print("결과 인덱스:", result)
    except ValueError as e:
        print(f"입력 오류: {e}", file=sys.stderr)
        sys.exit(1)

if __name__ == "__main__":
    main()