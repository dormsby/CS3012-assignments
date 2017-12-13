from github import Github 
import getpass


#https://github.com/PyGithub/PyGithub

#print user repo's


# using username and password
user = raw_input("Enter username: ")
password = getpass.getpass('Enter password: ')

g = Github(user, password)

# Then play with your Github objects:
for repo in g.get_user().get_repos():
    print repo.name


