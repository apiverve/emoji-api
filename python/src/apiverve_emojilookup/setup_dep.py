from setuptools import setup, find_packages

setup(
    name='apiverve_emojilookup',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Emoji Lookup searches emoji characters, tags, or categories to return descriptive names and classifications. Query by raw symbol, keyword tag, or category to inspect matching emoji glyphs, text descriptions, and categories.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/emoji?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
