#!/usr/bin/env python3

import argparse
import logging
import os
import sys
import configparser

# copy the aws credentials from one ini file to another.

def copy_credentials(src_file, src_profile, dest_file, dest_profile):
    input_config = configparser.ConfigParser()
    output_config = configparser.ConfigParser()

    src_file = os.path.expanduser(src_file)
    dest_file = os.path.expanduser(dest_file)

    if os.path.isfile(src_file):
        input_config.read(src_file)
        if src_profile in input_config:
            output_config.read(dest_file)
            output_config[dest_profile] = input_config[src_profile]
            with open(dest_file, 'w') as output:
                output_config.write(output)
        else:
            logging.error("can't find the profile '{}' in source file {}.".format(src_profile, src_file))
    else:
        logging.error("can't find the source file {}.".format(src_file))


def parse_args():
    parser = argparse.ArgumentParser(description='command line tool to copy aws credentials from one file to another.')
    parser.add_argument('--src_file', default='~/Downloads/credentials',
                        help="Source credentials file name. Default is ~/Downloads/credentials.")
    parser.add_argument('--src_profile', default='default',
                        help="Source profile name to copy credentials from. Default is 'default'.")
    parser.add_argument('--dest_file', default='~/.aws/credentials',
                        help="Destination credentials file name. Default is ~/.aws/credentials.")
    parser.add_argument('--dest_profile', default='default',
                        help="Destination profile name to copy credential to. Default is 'default'.")

    args = parser.parse_args()
    return args

def main():
    args = parse_args()
    copy_credentials(args.src_file, args.src_profile, args.dest_file, args.dest_profile)

if __name__ == '__main__':
    logging.getLogger().setLevel(logging.INFO)
    main()
