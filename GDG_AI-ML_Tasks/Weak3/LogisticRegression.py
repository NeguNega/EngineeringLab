import os
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns


from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler

from sklearn.linear_model import LogisticRegression

from sklearn.metrics import accuracy_score, confusion_matrix, classification_report

csv_file = "breast_cancer_bd.csv"
if not os.path.isfile(csv_file):
    print(f"Error: '{csv_file}' not found in the current folder.")
    print("Make sure the CSV file is in the same folder as this script.")
    exit()


df = pd.read_csv("breast_cancer_bd.csv")

df.head() # Displaying the first 5 rows to check correct loading of the given dataset.
print(df.shape)      # rows x columns
print(df.info())     # column types and missing data
print(df.describe()) # basic stats of numeric columns
print(df.isnull().sum()) #checking which value has missing value

# Fill missing values → df.fillna(value)
df['Bare Nuclei'] = df['Bare Nuclei'].replace('?', np.nan) # Replace '?' with NaN
df['Bare Nuclei'] = df['Bare Nuclei'].astype(float)   # Convert to float
median_value = df['Bare Nuclei'].median()   # Fill missing values safely
df['Bare Nuclei'] = df['Bare Nuclei'].fillna(median_value)

print(df.isnull().sum())

df = df.drop(columns=['Sample code number'], errors='ignore') # Drop the 'Sample code number' column

# df.head(25) # Check the first 25 rows to confirm dropping of the column
X = df.drop(columns=['Class']) # Features (all columns except 'Class')

y = df['Class'] # Target
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.3, random_state=42) # Split: 70% training, 30% testing


#check shapes
print("X_train:", X_train.shape)
print("X_test:", X_test.shape)
print("y_train:", y_train.shape)
print("y_test:", y_test.shape)
scaler = StandardScaler() # Initialize scaler
X_train_scaled = scaler.fit_transform(X_train) # Fit scaler on training data and transform

X_test_scaled = scaler.transform(X_test) # Transform test data (don’t fit again!)
model = LogisticRegression() # Initialize  and tran model

model.fit(X_train_scaled, y_train)

# Predict on test data and Check first 10 predictions
y_pred = model.predict(X_test_scaled)

print(y_pred[:10])

accuracy = accuracy_score(y_test, y_pred)
print("Accuracy:", accuracy)


cm = confusion_matrix(y_test, y_pred)
print("Confusion Matrix:\n", cm)

sns.heatmap(cm, annot=True, fmt="d", cmap="Blues")
plt.xlabel("Predicted")
plt.ylabel("Actual")
plt.show()

report = classification_report(y_test, y_pred)
print("Classification Report:\n", report)
