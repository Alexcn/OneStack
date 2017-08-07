from django.core.management.base import BaseCommand, CommandError
from django.core import management
import subprocess


class Command(BaseCommand):
    help = '初始化环境'

    def add_arguments(self, parser):
        parser.add_argument('dev', type=str)

    def handle(self, *args, **options):
        # self.execute('pip install django')
        # management.call_command('runserver')
        subprocess.call('pip install -r requirements/dev.txt', shell=True)

