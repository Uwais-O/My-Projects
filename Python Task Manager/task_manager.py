

# ====================Section for functions======================================================================================================

# Function to register user
def reg_user():
    # if input was 'r' , user would be prompted for input
    # The input would be written to user.txt file
    new_username = input("Please enter your desired username: ")
    new_password = input("Please enter a password to protect your account: ")
    confirmation_pass = input("Please confirm your password: ")
    
    # Used if and else statements to set logic for
    # username and password being written 
    if new_username == username:
        print("This username already exists")
    
    elif new_password == confirmation_pass:
            with open('user.txt','a+') as f:
                f.write('\n' + new_username + ", " + new_password)
            
    else:
        print("Your password do not match, please try again. ")

# Function to add task
def add_task():
    # Asked user for input of details
    username_01 = input("Please enter the user associated with the task: ")
    task_title = input("Please enter the title of the task: ")
    description = input("Please enter a description of the task: ")
    due_date = input("Please enter the due date of the task: ")
    assigned_date = input("Please enter the current date: ")
    # Wrote details to tasks file
    # Used a function to avoid overwriting entire file
    with open('tasks.txt', 'a') as f:
        f.write(username_01 + ", " + task_title + ", " + description + ", " + due_date + ", " + assigned_date + ", No")

# Function to view all
def view_all():
    # Split file into a list
    # Used list to print a string to read data in a more 
    # user friendly manner
    with open('tasks.txt','r+') as v:
           for line in v:
               linesplit = line.split(",")
               print("Task: "+ linesplit[1] + '\n' + 
              "Assigned to: " + linesplit[0] + '\n' + 
              "Date assigned: " + linesplit[3] + "\n" +
              "Due date: " + linesplit[4] + "\n" +
              "Task Complete: " + linesplit[5]  + "Task Description: " + "\n" + linesplit[2] + "\n")

# Function to display menu for user

def show_user_menu():
    menu = input('''Select one of the following Options below:
a - Adding a task
va - View all tasks
vm - view my task
e - Exit
: ''').lower()

# Function to display menu for admin
def show_admin_menu():
     input('''Select one of the following Options below:
r - Registering a user
a - Adding a task
va - View all tasks
vm - View my task
gr - Generate reports
ds - Display statistics (admin only)
e - Exit
: ''').lower()

# Function for view mine for user
def view_mine_user():
        # Added a counter variable
        task_no = 0
        # Opened tasks as f
        with open('tasks.txt', 'r+') as f:
                for line in f:
                        # increased counter variable for each line
                        task_no = 1 + task_no
                        # Split lines into lists 
                        # Comma as separator
                        task_list = line.split(", ")
                        # For everyline where username of user was present
                        # in other words - 
                        # For every task that was the users 
                        if username_input == task_list[0]:
                                # It was printed in a readable manner with
                                # a counter variable
                                print()
                                print(str(task_no)+")" + '\n'+ "Task: "+ task_list[1] + '\n' +
                                "Assigned to: " + task_list[0] + '\n' + 
                                "Date assigned: " + task_list[3] + "\n" + 
                                "Due date: " + task_list[4] + "\n" + 
                                "Task Complete: " + task_list[5]  + "Task Description: " + '\n' + task_list[2])

        # Asked user for input, 3 recognized options
        task_choice = input('''
        If you would like to edit a task please enter 'Edit' : 
        If you would like to mark task as complete please enter 'Mark Complete' : 
        If you would like to return to the main menu please enter '-1' : ''')

        # If user entered 'Edit'
        # The task number would be requested and subtracted by one
        # Since values begin from 0
        if task_choice == "Edit":
                task_num = int(input("Please enter the task number: "))
                task_num = task_num - 1 
                d_or_n = input("Type 'Name' to edit the username or 'Date' to edit the date: ")
                
        
                # Created 2 functions following the same logic
                
                # Function to edit username
                def edit_name():
                        # Asked user for new username
                        new_name = input("Enter the new Username: ")
                        #Opened task and read lines
                        with open('tasks.txt', 'r+') as file:
                                taskFile = file.readlines()
                                # Used [task_num] / user input to
                                # iterate through the desired lines
                                for line in taskFile[task_num]:
                                        # Split line and stored as newstr
                                        newstr = taskFile[task_num].split(',')

                                        # Used replace function to replace
                                        # desired characters by user input
                                        finalstr = taskFile[task_num].replace(newstr[0],new_name) 
                                # Wrote it to file
                                file.write('\n' + finalstr)
                

                        # Code to remove initial line
                        # Wrote code top remove line since the edited version was appended
                        with open('tasks.txt','r') as f:
                                lines = f.readlines()
                        # Used enumerate to iterate through lines via numbers
                        with open('tasks.txt','w') as f:
                                for number, line in enumerate(lines):
                                        # Used user input to find and remove line
                                        if number not in [task_num]:
                                                f.write(line)

                # edit date followed the exact same logic as 
                # edit_name()
                # Only difference was input variable and 'newstr' value
                def edit_date():
                        # Asked user for new date input
                        new_date = input("Enter the new Due Date: ")
        
                        with open('tasks.txt', 'r+') as file:
                                taskFile = file.readlines()
                                for line in taskFile[task_num]:
                                        newstr = taskFile[task_num].split(',')

                                        # Replaced old date / newstr[4] with user input
                                        finalstr = taskFile[task_num].replace(newstr[4],new_date) 
                                file.write('\n' + finalstr)

                        with open('tasks.txt','r') as f:
                                lines = f.readlines()

                        with open('tasks.txt','w') as f:
                                for number, line in enumerate(lines):
                                        if number not in [task_num]:
                                                f.write(line) 
                
                if d_or_n == "Name":
                    edit_name()
                elif d_or_n == "Date":
                    edit_date()  


        # If task choice user input was Mark Complete
        if task_choice == "Mark Complete":
                # Created mark complete function
                # Exact same logic as first two functions above
                # Only adjustment made was the value that was replaced
                # in other words
                # The changing of Yes/No to Yes
                def mark_complete():
                        
                        with open('tasks.txt', 'r+') as file:
                                taskFile = file.readlines()
                                for line in taskFile[task_num]:
                                        newstr = taskFile[task_num].split(',')

                                        # Replaced Yes/No value / newstr[5] 
                                        # with Yes
                                        
                                        finalstr = taskFile[task_num].replace(newstr[5],'Yes') 
                                file.write('\n' + finalstr)

                        with open('tasks.txt','r') as f:
                                lines = f.readlines()

                        with open('tasks.txt','w') as f:
                                for number, line in enumerate(lines):
                                        if number not in [task_num]:
                                                f.write(line)        
                mark_complete()

        # If task choice was -1, menu function would be called
        if task_choice == '-1':
            show_user_menu()

#Function for view mine for admin
def view_mine_admin():
        # Added a counter variable
        task_no = 0
        # Opened tasks as f
        with open('tasks.txt', 'r+') as f:
                for line in f:
                        # increased counter variable for each line
                        task_no = 1 + task_no
                        # Split lines into lists 
                        # Comma as separator
                        task_list = line.split(", ")
                        # For everyline where username of user was present
                        # in other words - 
                        # For every task that was the users 
                        if username_input == task_list[0]:
                                # It was printed in a readable manner with
                                # a counter variable
                                print()
                                print(str(task_no)+")" + '\n'+ "Task: "+ task_list[1] + '\n' +
                                "Assigned to: " + task_list[0] + '\n' + 
                                "Date assigned: " + task_list[3] + "\n" + 
                                "Due date: " + task_list[4] + "\n" + 
                                "Task Complete: " + task_list[5]  + "Task Description: " + '\n' + task_list[2])

        # Asked user for input, 3 recognized options
        task_choice = input('''
        If you would like to edit a task please enter 'Edit' : 
        If you would like to mark task as complete please enter 'Mark Complete' : 
        If you would like to return to the main menu please enter '-1' : ''')

        # If user entered 'Edit'
        # The task number would be requested and subtracted by one
        # Since values begin from 0
        if task_choice == "Edit":
                task_num = int(input("Please enter the task number: "))
                task_num = task_num - 1 
                d_or_n = input("Type 'Name' to edit the username or 'Date' to edit the date: ")
                
                # Created 2 functions following the same logic
                
                # Function to edit username
                def edit_name():
                        # Asked user for new username
                        new_name = input("Enter the new Username: ")
                        #Opened task and read lines
                        with open('tasks.txt', 'r+') as file:
                                taskFile = file.readlines()
                                # Used [task_num] / user input to
                                # iterate through the desired lines
                                for line in taskFile[task_num]:
                                        # Split line and stored as newstr
                                        newstr = taskFile[task_num].split(',')

                                        # Used replace function to replace
                                        # desired characters by user input
                                        finalstr = taskFile[task_num].replace(newstr[0],new_name) 
                                # Wrote it to file
                                file.write('\n' + finalstr)
                        
                        # Code to remove initial line
                        # Wrote code top remove line since the edited version was appended
                        with open('tasks.txt','r') as f:
                                lines = f.readlines()
                        # Used enumerate to iterate through lines via numbers
                        with open('tasks.txt','w') as f:
                                for number, line in enumerate(lines):
                                        # Used user input to find and remove line
                                        if number not in [task_num]:
                                                f.write(line)

                # edit date followed the exact same logic as 
                # edit_name()
                # Only difference was input variable and 'newstr' value
                def edit_date():
                        # Asked user for new date input
                        new_date = input("Enter the new Due Date: ")
        
                        with open('tasks.txt', 'r+') as file:
                                taskFile = file.readlines()
                                for line in taskFile[task_num]:
                                        newstr = taskFile[task_num].split(',')

                                        # Replaced old date / newstr[4] with user input
                                        finalstr = taskFile[task_num].replace(newstr[4],new_date) 
                                file.write('\n' + finalstr)

                        with open('tasks.txt','r') as f:
                                lines = f.readlines()

                        with open('tasks.txt','w') as f:
                                for number, line in enumerate(lines):
                                        if number not in [task_num]:
                                                f.write(line) 
                if d_or_n == "Name":
                    edit_name()
                elif d_or_n == "Date":
                    edit_date()  

        # If task choice user input was Mark Complete
        if task_choice == "Mark Complete":
                # Created mark complete function
                # Exact same logic as first two functions above
                # Only adjustment made was the value that was replaced
                # in other words
                # The changing of Yes/No to Yes
                def mark_complete():
                        
                        with open('tasks.txt', 'r+') as file:
                                taskFile = file.readlines()
                                for line in taskFile[task_num]:
                                        newstr = taskFile[task_num].split(',')

                                        # Replaced Yes/No value / newstr[5] 
                                        # with Yes
                                        
                                        finalstr = taskFile[task_num].replace(newstr[5],'Yes') 
                                file.write('\n' + finalstr)

                        with open('tasks.txt','r') as f:
                                lines = f.readlines()

                        with open('tasks.txt','w') as f:
                                for number, line in enumerate(lines):
                                        if number not in [task_num]:
                                                f.write(line)        
                mark_complete()

        # If task choice was -1, menu function would be called
        if task_choice == '-1':
            show_admin_menu()

# Function to generate task_overview file
def task_overview():
    #Total number of tasks generated
    # used readlines function and len to get the number of lines
    # this translated to number of tasks
    # since each task was assigned to one line
    with open('tasks.txt','r') as f:
        lines_num = len(f.readlines())
    
    # Number of tasks completed and uncompleted
    # used count function to 
    # count the times the word yes and no appeared
    # this allowed to count incompleted and complete tasks
    f = open('tasks.txt','r')
    read_data = f.read()
    completed = read_data.lower().count('yes')
    uncompleted = read_data.lower().count('no')
    
    # Number of tasks overdue
    # Set 2 counter variables
    not_overdue = 0
    overdue = 0
    # Opened file and split it into a list
    # Split date value(5th element) into a list from original list
    with open('tasks.txt','r') as f:
        for line in f:
            split1 = line.split(", ")
            split2_due = split1[4].split(" ")
            
            # Created dictionary for months and the month number as key
            month = {"Jan":"01", 
                "Feb":"02",
                "Mar": "03",
                "Apr":"04", 
                "May":"05", 
                "Jun":"06", 
                "Jul":"07",
                "Aug":"08",
                "Sep":"09", 
                "Oct":"10", 
                "Nov": "11",
                "Dec":"12"}
        
         # Ran the month dictionary to reflect number of the month
         # Did this so the datetime function could run on the values
         # stored the month number as due_month
        due_month = month[split2_due[1]]

         # Ran the function and entered the values of the date string[split2_due]
        # in the form yy/mm/dd
        import datetime
        due_date = datetime.datetime(int(split2_due[2]),int(due_month),int(split2_due[0]))
        
        # used if statement to..
        # compare date from task to todays date
        # if the due date from task was less then todays date
        # in other words if task was overdue
        # counter variable would increase (overdue)
        if due_date < datetime.datetime.today():
            overdue += 1
        # else not_overdue counter would increase
        else:
            not_overdue += 1
    
    # Created two formulas to calculate incomplete and completed %
    # for incomplete - tasks incomplete divided by total tasks, multiplied by 100
    # for overdue - tasks overdue divided by total tasks, multiplied by a 100 
    percent_incomplete = (int(uncompleted)/int(completed)+int(uncompleted))*100
    percent_overdue = (int(overdue)/(int(not_overdue)+int(overdue)))*100
    
    # Writing above data to file 
    # In a user-friendly manner
    with open("task_overview.txt","w") as t:
        t.write( "Total number of tasks generated: " + str(lines_num) + '\n'
                 "Total number of tasks completed: " + str(completed) + '\n'
                 "Total number of tasks incompleted: " + str(uncompleted) + '\n'
                 "Total number of tasks overdue: " + str(overdue) + '\n'
                 "Percentage incomplete: " + str(percent_incomplete) + "%" + '\n'
                 "Percent overdue: " + str(percent_overdue) +"%"
                 )


# Function to generate user_overview.txt
def user_overview():
    
    # Used a for loop and counter variable
    # to count lines thereby counting users from user.txt 
    with open('user.txt','r') as f:
        usercount = 0
        for lines in f:
            usercount += 1
    
    # Tasks per user
    # Used count function to count the appearence of username of user
    # This logic will therefore count the amount of tasks for that user
    # Since username appears once at the beginning of file
    taskf = open('tasks.txt','r')
    read_data = taskf.read()
    tasks_user = read_data.lower().count(username)

    # Tasks not per user
    # Code which records number of tasks 
    # not assigned to user
    # Set a counter variable
    task_notuser = 0
    # Split lines into a list called qlist 
    with open('tasks.txt','r') as q:
        for line in q:
            qsplit = line.split(", ")
            # Used an if statement
            # If first value of list is not equal to username
            # Counter variable would be increased
            if qsplit[0] != username:
                task_notuser += 1

    # % assigned to user
    # used a formula to work out %
    # tasks of user divided by total tasks, multiplied by a 100
    percentage_assigned = (int(tasks_user)/(int(tasks_user)+int(task_notuser)))*100

    # % completed 
    # Code to work out complete and incomplete tasks
    # Set two counter variables
    completed_1 = 0
    uncompleted_1 = 0
    # Opened file and split once again into a list
    with open("tasks.txt","r") as c:
        for lines in c:
            csplit = lines.split(", ")
            # Used an if statement to set logic that if
            # first value was username and fifth was a yes
            # then completed_1 counter variable would increase
            if csplit[0] == username and csplit[5] == "Yes":
                completed_1 += 1
            # else the uncompleted_1 counter variable would increase
            else:
                uncompleted_1 += 1
    
    # Two formulas to calculate % of completed and incompleted
    # completed over total mulitplied by a 100
    # incomplete over total multiplied by a 100
    user_percent_comp = (int(completed_1)/(int(completed_1)+int(uncompleted_1)))*100
    user_percent_incomp = (int(uncompleted_1)/(int(completed_1)+int(uncompleted_1)))*100

    # code to get % overdue
    # Set 2 counter variables
    user_overdue = 0
    usernot_overdue = 0
    # Opened file and split into a list
    # Used if statement to set logic that
    # if first character is username of user
    # code will execute
    with open("tasks.txt","r") as a:
        for lines in a:
            asplit = lines.split(", ")
            if asplit[0] == username:
                # Split the date string(asplit[0]) into a new list
                asplit_due = asplit[4].split(" ")
                # Created a dictionary for months and set keys as month number
                month = {"Jan":"01", 
                    "Feb":"02",
                    "Mar": "03",
                    "Apr":"04", 
                    "May":"05", 
                    "Jun":"06", 
                    "Jul":"07",
                    "Aug":"08",
                    "Sep":"09", 
                    "Oct":"10", 
                    "Nov": "11",
                    "Dec":"12"}
                
                # Ran the month dictionary to reflect number of the month
                # Did this so the datetime function could run on the values
                # stored the month number as due_month_1 
                due_month_1 = month[asplit_due[1]]
                #imported datettime module
                import datetime

            # Ran the function and entered the values of the date string[asplit]
            # in the form yy/mm/dd
            due_date = datetime.datetime(int(asplit_due[2]),int(due_month_1),int(asplit_due[0]))
            
            # used if statement to..
            # compare date from task to todays date
            # if the due date from task was less then todays date
            # in other words if task was overdue
            # counter variable would increase (user_overdue)
            if due_date < datetime.datetime.today():
                user_overdue += 1
            # else other counter variable would increase (usernot_overdue)    
            else:
                usernot_overdue += 1
    
    # Set formula to calculate % over due
    # user_overdue variable over total of tasks overdue and not over due
    # multiplied by 100
    percent_overdue = (int(user_overdue)/(int(usernot_overdue)+int(user_overdue)))*100
    
    # Wrote the information to a new file(user_overview.txt)
    # in a user friendly manner
    with open('user_overview.txt','w') as overview:
        overview.write( "Total number of users: " + str(usercount) + '\n'
                    "Percentage of total tasks assigned to user: " + str(percentage_assigned) +"%" + '\n'
                    "Percentage assigned that is completed: " + str(user_percent_comp)+"%" + '\n'
                    "Percentage assigned that is incomplete: " + str(user_percent_incomp) + "%" + '\n'
                    "Percentage of tasks overdue: " + str(percent_overdue) + "%"
                    )

# Function to generate reports
# Calls user_overview and task_overview function
def generate_report():
    user_overview()
    task_overview()

# Created a function to display stats for admin
def display_stats():
    # Imported os.path module
    # Used module to determine if files existed already
    # Used an if statement which called generate_report function
    # if files did not exist
    import os.path
    if not os.path.exists('task_overview.txt') and not os.path.exists('user_overview.txt'):
        generate_report()
    
    # If files did exist, printed them out
    # in a user friendly manner
    else:
        file1 = open('user_overview.txt','r') 
        file2 = open('task_overview.txt')
            
        file1_read = file1.read()
        file2_read = file2.read()

        print("Task overview" + '\n' + file2_read + '\n')
        print("User overview" + '\n' + file1_read)






#======= Login Section==========================================================================================================================

# Created an empty list to store inputs
# Asked user for required inputs and stored as variables
# Added inputs to list via append function
account_info = []
username_input = input("Please enter your username: ")
password_input = input("Please enter your password: ")
account_info.append(username_input + "" + password_input)

# Opened user.txt file to read and write
# Used a for loop 
# Split the string into a list separated by a space
# Stored items from list into 2 separate variables
# - "username" and "password"
# Removed comma via strip function
with open('user.txt', 'r+') as info:
    for line in info:
        account_list = line.split()
        username = account_list[0].strip(", ")
        password = account_list[1]

# Used if and elif statements to set preconditions for 
# user input as per instructions        
if username_input == username and password_input != password:
    print("The password is incorrect. Please try again ")

elif username_input!= username and password_input != password:
    print("The username is incorrect. Please try again ")

elif username_input != username and password_input != password:
    print("The username and password is incorrect")

# =========Section for User===================================================================================================================

# When neither of the above preconditions are met, 
# used aN elif statment to generate a menu
# Menu was preset to take input and convert into lowercase
# Used 'not' and 'and' statements to 
# furhter specify conditions for menu to appear
elif username_input!= "admin" and username_input == username and password_input == password:
    #presenting the menu to the user and 
    # making sure that the user input 
    # is coneverted to lower case.
    menu = input('''Select one of the following Options below:
a - Adding a task
va - View all tasks
vm - view my task
e - Exit
: ''').lower()

# Used statements to set conditions for each of the options

    # If user input was 'a'
    # add_task function would be called
    if menu == 'a':
        
        add_task()
      

    # if user input was 'vm'..
    # view_mine_user() function would be called
    elif menu == 'vm':
        view_mine_user()

    # if user input was 'va'..
    # view_all function would be called 
    elif menu == "va":
        view_all()
       
    
    elif menu == 'e':
        print('Goodbye!!!')
        exit()

    else:
        print("You have made a wrong choice, Please Try again")


# =========Section for admin==================================================================================================================

# Code was repeated but slightly altered 
# for extra features for admin
# Used a while loop 
# Loop was dictated by an and statement
# and statement set conditons for
# ..new menu for admin users
# relied on user input of of username being "admin"

while username_input == 'admin' and password_input == password:
    menu = input('''Select one of the following Options below:
r - Registering a user
a - Adding a task
va - View all tasks
vm - View my task
gr - Generate reports
ds - Display statistics (admin only)
e - Exit
: ''').lower()

# Used statements to set conditions for each of the options

    # if input was 'r' , user would be prompted for input
    # The input would be written to user.txt file
    if menu == 'r':
        new_username = input("Please enter your desired username: ")
        new_password = input("Please enter a password to protect your account: ")
        confirmation_pass = input("Please confirm your password: ")
        # Used an if statement to write to file if variables;
        # "new_password" and "confirmation_password" were equal
        if new_password == confirmation_pass:
            with open('user.txt','a+') as f:
                f.write('\n' + new_username + ", " + new_password)
            
        
        else:
            print("Your password do not match, please try again. ")
    
   
     # if input was "a"
     # Addtask function would be called 
    elif menu == 'a':
        add_task()

    # If input was 'vm'
    # view_mine_admin() would be called
    elif menu == 'vm':
       view_mine_admin()

    # if user input was = 'va'
    # view_all fucntion would be called
    elif menu == "va":
        view_all()
      
    elif menu == 'e':
        print('Goodbye!!!')
        exit()
     
     
#=============New option for admin=============================================================================================================
    
    # If user input was 'gr'
    # generate_function would be called 
    elif menu == 'gr':
        generate_report()


    # if user input was ds
    # display_stats function would be called
    elif menu == 'ds':
       display_stats()