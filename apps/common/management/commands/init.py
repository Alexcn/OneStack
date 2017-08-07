from django.core.management.base import BaseCommand, CommandError


class Command(BaseCommand):
    help = '初始化环境'

    def add_arguments(self, parser):
        parser.add_argument('dev', type=str)

    def handle(self, *args, **options):
        pass
