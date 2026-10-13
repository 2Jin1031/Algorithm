def solution(a, b):
    res1 = int(str(a) + str(b))
    res2 = a * b * 2
    if (res1 < res2): res1 = res2
    return res1

