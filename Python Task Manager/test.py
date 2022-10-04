username_input = 'admin'
password_input = 'adm1n'
with open('user.txt', 'r+') as info:
    for line in info:
        account_list = line.split()
        username = account_list[0].strip(', ').split()
        password = account_list[1]
        
        for i in username and password:
            if i == username_input:
                print(i)