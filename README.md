# BIG DATA - SEARCH ENGINE

The goal of this assignment is to develop a search engine using an inverted index structure. The inverted or reverse index is a type of indexing used by search engines and documents-oriented databases, such as Google.

It allows quick searching of text documents and is a structure where, for each word, it is indicated the documents that contain the word. That is why, when a user enters a specific search term, the search of the documents that contain this term is really fast.

The data will be collected from Project Gutenberg, a library of free books mainly in the public domain.

## THE PROJECT ITSELF

The following repository includes the entire proyect. There are different deliveries of the task:
- Inverted index
- Crawler development
- Query engine development
- Set Up Google Cloud Platform
- Development of indexer module
- Evolve the reverse index to use hazelcast
- Final integration

Right now, we have finished the first and the second parts, and we keep going with the third one.

### INVERTED INDEX

This function builds a word-level inverted index from a collection of documents. It receives a document in ".txt" format, and will return a dictionary that will show the words of said document in addition to the lines in which it is found. The code has been developed in Python.

### CRAWLER DEVELOPMENT

The Crawler module download a document every minute from Project Gutenberg and store it in the Document Repository. The organization of the Document Repository is chronological with a folder for each date using the format yyyymmdd. This part have been developed using Java.

## THE WORK ENVIRONMENT

To develop the inverted index task we used Pycharm, from JetBrains, using Python 3.9 and 3.10.
To develop the crawler development we used IntelliJ IDEA, from JetBrains, using Java in its 11th version.

## THE DEVELOPMENT TEAM

The team behind the development of this great project is made up of 3 members:
- Cynthia Quintana Reyes
- Andrea Hernando González
- Aarón Perdomo Aspas
