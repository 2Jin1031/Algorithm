def solution(num_list, n):
    answer = []
    for a in num_list[::n]:
        answer.append(a)
    return answer