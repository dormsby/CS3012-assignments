from github import Github 
import getpass

#List all the repos and contributers of the logged in user.


# using username and password
user = raw_input("Enter username: ")
password = getpass.getpass('Enter password: ')

g = Github(user, password)

# Then play with your Github objects:

i =0
for repo in g.get_user().get_repos():
	print ""
	print "Repo Name: " + repo.name
	print "Contributors :"
	for contribs in repo.get_contributors():
		print contribs.login
	


